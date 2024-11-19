package textrpg.units;

import java.util.*;
import java.lang.reflect.Modifier;

import org.reflections.Reflections;


public class UnitBox {
	private final Map<Class<? extends Unit>, List<Class<? extends Unit>>> unitRegistry = new HashMap<>();
	private final Map<String, int[]> gradeRanges = new HashMap<>();
	private final Random random = new Random();
	private int currentRound;

	public UnitBox(String packageName, int currentRound) {
		this.currentRound = currentRound;
		initializeGradeRanges();
		registerUnits(packageName);
	}

	private void initializeGradeRanges() {
		gradeRanges.put("COMMON", new int[] { 0, 250 });
		gradeRanges.put("RARE", new int[] { 251, 321 });
		gradeRanges.put("UNIQUE", new int[] { 322, 510 });
		gradeRanges.put("EPIC", new int[] { 511, 580 });
		gradeRanges.put("LEGEND", new int[] { 581, 600 });
	}

	private void registerUnits(String packageName) {
		Reflections reflections = new Reflections(packageName);
		Set<Class<? extends Unit>> allUnits = reflections.getSubTypesOf(Unit.class);

		for (Class<? extends Unit> unitClass : allUnits) {
			if (!Modifier.isAbstract(unitClass.getModifiers())) {
				Class<?> parent = unitClass.getSuperclass();
				Class<? extends Unit> parentClass = parent.asSubclass(Unit.class);
				unitRegistry.computeIfAbsent(parentClass, k -> new ArrayList<>()).add(unitClass);
			}
		}
	}

	private int[] adjustRange(String grade) {
		int[] baseRange = gradeRanges.get(grade);
		int min = baseRange[0];
		int max = baseRange[1];

		if (currentRound <= 6) {
			max = Math.min(max + (currentRound - 1) * 50, 600);
		}

		else if (currentRound >= 7 && currentRound <= 9) {
			min = Math.min(min + (currentRound - 6) * 50, max);
		}

		else if (currentRound >= 10) {
			min = 200;
		}

		return new int[] { min, max };
	}

	private String selectGrade() {
		int roll = random.nextInt(601);
		for (Map.Entry<String, int[]> entry : gradeRanges.entrySet()) {
			int[] adjustedRange = adjustRange(entry.getKey());
			int min = adjustedRange[0];
			int max = adjustedRange[1];

			if (roll >= min && roll <= max) {
				return entry.getKey();
			}
		}
		return "COMMON";
	}

	public Unit generateUnit() {
		try {
			String grade = selectGrade();
			Class<? extends Unit> gradeClass = null;

			for (Class<? extends Unit> key : unitRegistry.keySet()) {
				if (key.getSimpleName().equalsIgnoreCase(grade)) {
					gradeClass = key;
					break;
				}
			}

			if (gradeClass == null) {
				throw new IllegalStateException("No units available for grade: " + grade);
			}

			List<Class<? extends Unit>> units = unitRegistry.get(gradeClass);
			Class<? extends Unit> selectedUnit = units.get(random.nextInt(units.size()));

			return selectedUnit.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	// 생성 체크 임시
	public static void main(String[] args) {
        UnitBox unitBox = new UnitBox("textrpg.units", 5); 
        Unit generatedUnit = unitBox.generateUnit();
        System.out.println("Generated Unit: " + generatedUnit);
    }

}