package tests;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Vector;

import tema4.Strings.StringManipulation;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StringManipulationTest {
    private StringManipulation sut;
    @Test
    public void given_empty_input_when_compute_inverse_then_empty_is_returned() {
        //Given
        String input = "";

        //When
        String returnedString = sut.reverseString(input);

        //Then
        assertThat(returnedString).isEmpty();
    }

    @Test
    public void given_null_input_when_compute_inverse_then_null_is_returned() {
        //Given
        String input = null;

        //When
        String returnedString = sut.reverseString(input);

        //Then
        assertThat(returnedString).isNull();
    }

    @Test
    public void given_string_input_when_compute_inverse_then_inverse_is_returned() {
        //Given
        String input = "abcdefg";

        //When
        String returnedString = sut.reverseString(input);

        //Then
        assertThat(returnedString).isEqualTo("gfedcba");
    }

    @Test
    public void given_string_with_spaces_input_when_compute_inverse_then_inverse_is_returned() {
        //Given
        String input = "abc_   defg  ";

        //When
        String returnedString = sut.reverseString(input);

        //Then
        assertThat(returnedString).isEqualTo(new StringBuilder(input).reverse().toString());
    }

    @Test
    public void given_empty_input_whem_compute_convert_the_empty_is_returned(){
        String input = "";
        int returnedInt = sut.convertToInt(input);
        assertThat(returnedInt).isEqualTo(0);
    }
    @Test
    public void given_null_input_when_compute_convert_the_null_is_returned(){
        String input = null;
        int returnedInt = sut.convertToInt(input);
        assertThat(returnedInt).isEqualTo(0);
    }
    @Test
    public void given_string_input_when_compute_convert_the_int_is_returned(){
        String input = "19";
        int returnedInt = sut.convertToInt(input);
        assertThat(returnedInt).isEqualTo(19);
    }
    @Test
    public void given_string_with_spaces_input_when_compute_convert_the_int_is_returned(){
        String input = "19   12";
        int returnedInt = sut.convertToInt(input);
        assertThat(returnedInt).isEqualTo(1912);
    }

    @Test
    public void given_string_s1_and_s2_input_when_check_if_there_are_anagrams(){
        String input1 = "masa";
        String input2 = "sama";
        boolean returnedCheck = sut.checkAnagrams(input1,input2);
        assertThat(returnedCheck).isTrue();
    }
    @Test
    public void given_string_s1_and_s2_input_when_check_if_there_are_not_anagrams(){
        String input1 = "masa";
        String input2 = "sams";
        boolean returnedCheck = sut.checkAnagrams(input1,input2);
        assertThat(returnedCheck).isFalse();
    }
    @Test
    public void given_empty_string_s1_and_s2_input_when_returned_false(){
        String input1 = "";
        String input2 = "";
        boolean returnedCheck = sut.checkAnagrams(input1,input2);
        assertThat(returnedCheck).isFalse();
    }
    @Test
    public void given_null_string_s1_and_s2_input_when_returned_false(){
        String input1 = null;
        String input2 = null;
        boolean returnedCheck = sut.checkAnagrams(input1,input2);
        assertThat(returnedCheck).isFalse();
    }
    @Test
    public void given_null_string_s1_and_no_null_s2_input_when_returned_false(){
        String input1 = null;
        String input2 = "asd";
        boolean returnedCheck = sut.checkAnagrams(input1,input2);
        assertThat(returnedCheck).isFalse();
    }
    @Test
    public void given_string_input_when_check_only_digits_then_true_is_returned(){
        String input = "12345";
        String returnedString = sut.checkDigits(input);
        assertThat(returnedString).isEqualTo("String contains only digits");
    }
    @Test
    public void given_null_string_input_when_check_only_digits_then_false_is_returned(){
        String input = null;
        String returnedString = sut.checkDigits(input);
        assertThat(returnedString).isEqualTo("String is empty / null");
    }
    @Test
    public void given_empty_string_input_when_check_only_digits_then_false_is_returned(){
        String input = "";
        String returnedString = sut.checkDigits(input);
        assertThat(returnedString).isEqualTo("String is empty / null");
    }
    @Test
    public void given_string_with_characters_input_when_check_only_digits_then_false_is_returned(){
        String input = "1234ss23";
        String returnedString = sut.checkDigits(input);
        assertThat(returnedString).isEqualTo("String contains characters");
    }
    @Test
    public void given_string_and_character_input_when_compute_occurent_of_char_then_occurence_is_returned(){
        String input = "abbdcaaaaerdaas";
        char c = 'a';
        int returnedOccurence = sut.countOccurence(input,c);
        assertThat(returnedOccurence).isEqualTo(7);
    }
    @Test
    public void given_empty_string_and_character_input_when_compute_occurent_of_char_then_0_is_returned(){
        String input = "";
        char c = 'a';
        int returnedOccurence = sut.countOccurence(input,c);
        assertThat(returnedOccurence).isEqualTo(0);
    }

    @Test
    public void given_string_input_when_computes_vowels_and_consonants_then_occurence_is_returned(){
        String input = "abcdefgh";
        Vector returned = sut.countVowelsAndConsonants(input);
        assertThat(returned).contains(2,6);
    }
    @Test
    public void given_empty_string_input_when_computes_vowels_and_consonants_then_occurence_is_returned(){
        String input = "";
        Vector returned = sut.countVowelsAndConsonants(input);
        assertThat(returned).contains(0,0);
    }
    @Test
    public void given_null_string_input_when_computes_vowels_and_consonants_then_occurence_is_returned(){
        String input = null;
        Vector returned = sut.countVowelsAndConsonants(input);
        assertThat(returned).contains(0,0);
    }
    @Test
    public void given_numbers_string_input_when_computes_vowels_and_consonants_then_occurence_is_returned(){
        String input = "12345";
        Vector returned = sut.countVowelsAndConsonants(input);
        assertThat(returned).contains(0,0);
    }
    @Test
    public void given_string_input_when_computes_reverse_then_reverse_is_returned(){
        String input = "asda dasd";
        String returnedReverse = sut.inverseWords(input);
        assertThat(returnedReverse).isEqualTo("dasd asda");
    }
    @Test
    public void given_empty_input_when_computes_reverse_then_empty_reverse_is_returned(){
        String input = "";
        String returnedReverse = sut.inverseWords(input);
        assertThat(returnedReverse).isEqualTo("");
    }
    @Test
    public void given_null_input_when_computes_reverse_then_null_is_returned(){
        String input = null;
        String returnedReverse = sut.inverseWords(input);
        assertThat(returnedReverse).isEqualTo(null);
    }
    @Test
    public void given_string_input_when_computes_most_frequent_string_then_most_frequent_is_returned(){
        String input = "a a asd asd asd ad asd ere ere a";
        String returnedReverse = sut.printMostFrequentString(input);
        assertThat(returnedReverse).isEqualTo("asd");
    }
    @Test
    public void given_empty_string_input_when_computes_most_frequent_string_then_empty_is_returned(){
        String input = "";
        String returnedReverse = sut.printMostFrequentString(input);
        assertThat(returnedReverse).isEqualTo("");
    }
    @Test
    public void given_null_string_input_when_computes_most_frequent_string_then_null_is_returned(){
        String input = null;
        String returnedReverse = sut.printMostFrequentString(input);
        assertThat(returnedReverse).isEqualTo(null);
    }

    @Before
    public void setup() {
        sut = new StringManipulation();
    }


}
