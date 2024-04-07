package com.master.util;

public class AmtInWord {

	public static void main(String... s) {
		float f = 2002.9f;
		int i = (int) f;

		Float flt = 1001.12f;
		// String str = flt.toString();
		// Integer integ = Integer.parseInt(str);

		// NumberFormat nf = NumberFormat.getInstance();
		// nf.format(flt);

		System.out.println(getAmtInWord(1212.03f));
	}

	public static String getAmtInWord(float amount) {
		int amt1 = (int) amount;
		Float ff = amount;
		String str = ff.toString();
		str = str.substring(str.indexOf('.') + 1, str.length() - 1);
		System.out.println(amt1);
		String hun = "Hundred";
		String tha = "Thousand";
		String lak = "Lac";
		StringBuffer stringBuffer = new StringBuffer();
		String first_digit = "";
		String second_digit = "";
		String third_digit = "";
		String four_digit = "";

		Integer amt = amt1;
		String testamout = amt.toString();
		String inword[] = { "", "One", "Two", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
				"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
				"Eighteen", "Ninteen", "Twenty", "Twenty One", "Twenty Two",
				"Twenty Three", "Twenty Four", "Twenty Five", "Twenty Six",
				"Twenty Seven", "Twenty Eight", "Twenty Nine", "Thirty",
				"Thirty One", "Thirty Two", "Thirty Three", "Thirty Four",
				"Thirty Five", "Thirty Six", "Thirty Seven", "Thirty Eight",
				"Thirty Nine", "Fourty", "Fourty One", "Fourty Two",
				"Fourty Three", "Fourty Four", "Fourty Five", "Fourty Six",
				"Fourty Seven", "Fourty Eight", "Fourty Nine", "Fifty",
				"Fifty One", "Fifty Two", "Fifty Three", "Fifty Four",
				"Fifty Five", "Fifty Six", "Fifty Seven", "Fifty Eight",
				"Fifty Nine", "Sixty", "Sixty One", "Sixty Two", "Sixty Three",
				"Sixty Four", "Sixty Five", "Sixty Six", "Sixty Seven",
				"Sixty Eight", "Sixty Nine", "Seventy", "Seventy One",
				"Seventy Two", "Seventy Three", "Seventy Four", "Seventy Five",
				"Seventy Six", "Seventy Seven", "Seventy Eight",
				"Seventy Nine", "Eighty", "Eighty One", "Eighty Two",
				"Eighty Three", "Eighty Four", "Eighty Five", "Eighty Six",
				"Eighty Seven", "Eighty Eight", "Eighty Nine", "Ninety",
				"Ninety One", "Ninety Two", "Ninety Three", "Ninety Four",
				"Ninety Five", "Ninety Six", "Ninety Seven", "Ninety Eight",
				"Ninety Nine" };
		if (testamout.length() == 1) {

			String first_word = "";
			int count1 = Integer.parseInt(testamout);
			first_word = inword[count1];

			stringBuffer.append(first_word).append(" ");
			System.out.println("test1" + stringBuffer);
		}

		if (testamout.length() == 2) {

			first_digit = testamout.substring(0, 2);
			String first_word = "";
			int count1 = Integer.parseInt(first_digit);
			first_word = inword[count1];

			stringBuffer.append(first_word).append(" ");
			System.out.println("test1" + stringBuffer);
		}

		if (testamout.length() == 3) {

			first_digit = testamout.substring(0, 1);
			second_digit = testamout.substring(1, 3);

			// out.println(first);
			String first_word = "";
			String second_word = "";

			int count1 = Integer.parseInt(first_digit);
			int count2 = Integer.parseInt(second_digit);

			first_word = inword[count1];
			second_word = inword[count2];
			if (count1 == 0) {
				hun = "";
			}
			stringBuffer.append(first_word).append(" ").append(hun).append(" ")
					.append(second_word);

			System.out.println("test1" + stringBuffer);

		}

		if (testamout.length() == 4) {

			first_digit = testamout.substring(0, 1);
			second_digit = testamout.substring(1, 2);
			third_digit = testamout.substring(2, 4);
			// out.println(first);
			String first_word = "";
			String second_word = "";
			String third_word = "";
			int count1 = Integer.parseInt(first_digit);
			int count2 = Integer.parseInt(second_digit);
			int count3 = Integer.parseInt(third_digit);
			first_word = inword[count1];
			second_word = inword[count2];
			third_word = inword[count3];

			if (count1 == 0) {
				tha = "";
			}
			if (count2 == 0) {
				hun = "";
			}
			stringBuffer.append(first_word).append(" ").append(tha).append(" ")
					.append(second_word).append(" ").append(hun).append(" ")
					.append(third_word);
			System.out.println("test1" + stringBuffer);

		}

		if (testamout.length() == 5) {

			first_digit = testamout.substring(0, 2);
			second_digit = testamout.substring(2, 3);
			third_digit = testamout.substring(3, 5);
			// out.println(first);
			String first_word = "";
			String second_word = "";
			String third_word = "";
			int count1 = Integer.parseInt(first_digit);
			int count2 = Integer.parseInt(second_digit);
			int count3 = Integer.parseInt(third_digit);
			first_word = inword[count1];
			second_word = inword[count2];
			third_word = inword[count3];
			if (count1 == 0) {
				tha = "";
			}
			if (count2 == 0) {

				hun = "";

			}

			stringBuffer.append(first_word).append(" ").append(tha).append(" ")
					.append(second_word).append(" ").append(hun).append(" ")
					.append(third_word);

			System.out.println("test1" + stringBuffer);

		}
		if (testamout.length() == 6) {
			first_digit = testamout.substring(0, 1);
			second_digit = testamout.substring(1, 3);
			third_digit = testamout.substring(3, 4);
			four_digit = testamout.substring(4, 6);

			// out.println(first);
			String first_word = "";
			String second_word = "";
			String third_word = "";
			String four_word = "";
			int count1 = Integer.parseInt(first_digit);
			int count2 = Integer.parseInt(second_digit);
			int count3 = Integer.parseInt(third_digit);
			int count4 = Integer.parseInt(four_digit);
			first_word = inword[count1];
			second_word = inword[count2];
			third_word = inword[count3];
			four_word = inword[count4];
			if (count1 == 0) {
				lak = "";
			}
			if (count2 == 0) {
				tha = "";
			}
			if (count3 == 0) {
				hun = "";
			}

			stringBuffer.append(first_word).append(" ").append(lak).append(" ")
					.append(second_word).append(" ").append(tha).append(" ")
					.append(third_word).append(" ").append(hun).append(" ")
					.append(four_word);

			System.out.println("test1" + stringBuffer);

		}

		if (testamout.length() == 7) {
			first_digit = testamout.substring(0, 2);
			second_digit = testamout.substring(2, 4);
			third_digit = testamout.substring(4, 5);
			four_digit = testamout.substring(5, 7);

			// out.println(second_digit);
			String first_word = "";
			String second_word = "";
			String third_word = "";
			String four_word = "";
			int count1 = Integer.parseInt(first_digit);
			int count2 = Integer.parseInt(second_digit);
			int count3 = Integer.parseInt(third_digit);
			int count4 = Integer.parseInt(four_digit);
			first_word = inword[count1];
			second_word = inword[count2];
			third_word = inword[count3];
			four_word = inword[count4];
			if (count1 == 0) {
				lak = "";
			}
			if (count2 == 0) {
				tha = "";
			}
			if (count3 == 0) {
				hun = "";
			}

			stringBuffer.append(first_word).append(" ").append(lak).append(" ")
					.append(second_word).append(" ").append(tha).append(" ")
					.append(third_word).append(" ").append(hun).append(" ")
					.append(four_word);

			System.out.println("In Word" + stringBuffer.toString());

		}
		return stringBuffer.append(str).toString();
	}

}
