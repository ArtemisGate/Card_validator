package main;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



/**
 * @author Scott
 *
 * This Class takes a card number in range of 13 <= n <= 16
 * and uses Luhn’s algorithm to check if it's valid. It outputs
 * the card is valid or not and the card type. The card type supported
 * this program is Visa, Mastercard, American Experess. Other card types
 * are not supported at this time
 *
 *
 */
public class Main {

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		long card_num = 0;
		int card_digit = 0;
		int card_sum = 0;
		String card_type = "not supported by this program";



		// Get card number from user
		System.out.println("Please enter a card number: ");
		card_num = input.nextLong();
		input.close();

		// Call Digit method to get length of card
		card_digit = Digit.get_num_digit(card_num);




		// If card is no in range of 13 <= n <= 16 then quit
		if (card_digit < 13 || card_digit > 16)
		{
			System.out.println("Card is invalid");
			return;
		}



		// Find the first two digit of card to determine type
		int first_two_digit =  (int) (card_num / Math.pow(10, card_digit-2));


		// Determine type according to card conventions
		if(first_two_digit == 37 || first_two_digit ==36)
		{
			card_type = "AMEX";
		}
		else if ((first_two_digit/10) == 4)
		{
			card_type = "VISA";
		}
		else if ((first_two_digit/10) == 5 || first_two_digit/10 == 2)
		{
			card_type = "MASTERCARD";
		}

		// Get digits in card as an arraylist of ints
		List<Integer> digits = Digit.get_digits(card_num,card_digit);
		// Reverse the order of the digits
		Collections.reverse(digits);


		for(int i = card_digit -1; i >= 0 ; i--)
		{

			// Skip the checksum til end of loop
			if(i == card_digit -1 )
			{
				continue;
			}

			// If card's length is odd, double even numbers
			if(i % 2 == 1 && card_digit % 2 == 1)
			{
				digits.set(i, digits.get(i)*2);
			}
			// If card's length is even, double odd numbers
			else if(card_digit % 2 == 0 && i %2 == 0)
			{
				digits.set(i, digits.get(i)*2);
			}

			// Get card digit value
			int value = digits.get(i);

			// If value is doubled, gets the digits sum
			if(value > 9)
			{
				card_sum += value/10 + value % 10;
			}
			else
			{
				card_sum += value;
			}

		}


		// Add the checksum to total
		card_sum += digits.get(card_digit - 1);



		// See what the card sum is
        System.out.println("The card sum is " +card_sum);

        // Print out if card numbers are valid
        if(card_sum % 10 ==0)
        {
        	System.out.println("Card is Valid. Card is " + card_type);
        }
        else
        {
        	System.out.println("Card is invalid.");
        }




	}

}
