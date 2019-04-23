package com.yodlee.practice.fun;

/****
 * @author akumar23
 */
import java.util.Scanner;

public class Target {
	static int total_power_1;
	static int total_power_2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String input_battle_field = sc.nextLine();
		int row = input_battle_field.charAt(2) - 64;
		int col = Integer.parseInt(input_battle_field.charAt(0) + "" + "");
		int battle_field_1[][] = new int[row + 1][col + 1];
		int battle_field_2[][] = new int[row + 1][col + 1];

		Battle battle_1 = new Battle();
		battle_1.setType(sc.next());
		battle_1.setWidth(sc.nextInt());
		battle_1.setHeight(sc.nextInt());
		battle_1.setLocation_A(sc.next());
		battle_1.setLocation_B(sc.next());

		Battle battle_2 = new Battle();
		battle_2.setType(sc.next());
		battle_2.setWidth(sc.nextInt());
		battle_2.setHeight(sc.nextInt());
		battle_2.setLocation_A(sc.next());
		battle_2.setLocation_B(sc.next());
		sc.nextLine();
		String missile_1 = sc.nextLine();
		String missile_2 = sc.nextLine();
		fillArray(battle_1, battle_field_1, battle_field_2);
		fillArray(battle_2, battle_field_1, battle_field_2);

		String missile_set1[] = missile_1.split(" ");
		String missile_set2[] = missile_2.split(" ");
		int ii = 0;
		int jj = 0;
		boolean flag = true;
		while (ii < missile_set1.length && jj < missile_set2.length) {
			if (flag) {
				String ms = missile_set1[ii];
				int row_to_hit = ms.charAt(0) - 64;
				int col_to_hit = Integer.parseInt(ms.charAt(1) + "");
				if (battle_field_2[row_to_hit][col_to_hit] != 0) {
					total_power_2 = total_power_2 - 1;
					battle_field_2[row_to_hit][col_to_hit] = battle_field_2[row_to_hit][col_to_hit] - 1;
					System.out.println("Player-1 fires a missile with target "
							+ ms + " which hit");
					ii++;
					continue;
				}
				System.out.println("Player-1 fires a missile with target " + ms
						+ " which missed");
				ii++;
				flag = false;
			} else {
				String ms1 = missile_set2[jj];
				int rr = ms1.charAt(0) - 64;
				int cc = Integer.parseInt(ms1.charAt(1) + "");
				if (battle_field_1[rr][cc] != 0) {
					total_power_1 = total_power_1 - 1;
					battle_field_1[rr][cc] = battle_field_1[rr][cc] - 1;
					System.out.println("Player-2 fires a missile with target "
							+ ms1 + " which hit");
					jj++;
					continue;
				}
				System.out.println("Player-2 fires a missile with target "
						+ ms1 + " which missed");
				jj++;
				flag = true;
			}

		}

		while (ii < missile_set1.length) {
			System.out.println("Player-2 has no more missiles left");
			String ms = missile_set1[ii];
			int row_to_hit = ms.charAt(0) - 64;
			int col_to_hit = Integer.parseInt(ms.charAt(1) + "");
			if (battle_field_2[row_to_hit][col_to_hit] != 0) {
				total_power_2 = total_power_2 - 1;
				battle_field_2[row_to_hit][col_to_hit] = battle_field_2[row_to_hit][col_to_hit] - 1;
				System.out.println("Player-1 fires a missile with target " + ms
						+ " which hit");
				ii++;
				continue;
			}
			System.out.println("Player-1 fires a missile with target " + ms
					+ " which missed");
			ii++;

		}
		while (jj < missile_set2.length) {
			System.out.println("Player-1 has no more missiles left");
			String ms1 = missile_set2[jj];
			int rr = ms1.charAt(0) - 64;
			int cc = Integer.parseInt(ms1.charAt(1) + "");
			if (battle_field_1[rr][cc] != 0) {
				total_power_1 = total_power_1 - 1;
				battle_field_1[rr][cc] = battle_field_1[rr][cc] - 1;
				System.out.println("Player-2 fires a missile with target "
						+ ms1 + " which hit");
				jj++;
				continue;
			}
			System.out.println("Player-2 fires a missile with target " + ms1
					+ " which missed");
			jj++;

		}
		if (total_power_1 == 0)
			System.out.println("Player 2 won the battle");
		else if (total_power_2 == 0)
			System.out.println("Player 1 won the battle");
		else
			System.out.println("Peace");

	}

	private static void fillArray(Battle battle_1, int battle_field_1[][],
			int battle_field_2[][]) {
		if (battle_1.getType().equals("P")) {
			total_power_1 += (battle_1.getWidth() * battle_1.getHeight());
			total_power_2 = total_power_1;
			int row_position;
			row_position = battle_1.getLocation_A().charAt(0) - 64;
			int col_position;
			col_position = Integer.parseInt(battle_1.getLocation_A().charAt(1)
					+ "");
			for (int i = 0; i < battle_1.getHeight(); i++) {
				for (int j = 0; j < battle_1.getWidth(); j++) {
					battle_field_1[row_position + i][col_position + j] = 1;
				}
			}
			row_position = battle_1.getLocation_B().charAt(0) - 64;
			col_position = Integer.parseInt(battle_1.getLocation_B().charAt(1)
					+ "");
			for (int i = 0; i < battle_1.getHeight(); i++) {
				for (int j = 0; j < battle_1.getWidth(); j++) {
					battle_field_2[row_position + i][col_position + j] = 1;
				}
			}

		} else {

			total_power_1 += (2 * (battle_1.getWidth() * battle_1.getHeight()));
			total_power_2 = total_power_1;
			int row_position;
			row_position = battle_1.getLocation_A().charAt(0) - 64;
			int col_position;
			col_position = Integer.parseInt(battle_1.getLocation_A().charAt(1)
					+ "");
			for (int i = 0; i < battle_1.getHeight(); i++) {
				for (int j = 0; j < battle_1.getWidth(); j++) {
					battle_field_1[row_position + i][col_position + j] = 2;
				}
			}
			row_position = battle_1.getLocation_B().charAt(0) - 64;
			col_position = Integer.parseInt(battle_1.getLocation_B().charAt(1)
					+ "");
			for (int i = 0; i < battle_1.getHeight(); i++) {
				for (int j = 0; j < battle_1.getWidth(); j++) {
					battle_field_2[row_position + i][col_position + j] = 2;
				}
			}

		}
	}

}
