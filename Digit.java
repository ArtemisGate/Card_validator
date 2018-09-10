package main;
import java.util.ArrayList;
import java.util.List;

public class Digit
{

	static int get_num_digit(long num)
	{


		int count_digit = 0;



		while(num > 0)
		{

			num = num/10;
			count_digit++;
		}

		return count_digit;

	}

	static List<Integer> get_digits(long num, long digits)
	{
		List<Integer> card_digit = new ArrayList<Integer>();

		while (num > 0)
		{
			card_digit.add((int) (num % 10));
			num = num/10;


		}

		return card_digit;
	}
}
