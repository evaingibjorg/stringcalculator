package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("-")){
		return noNegativeNumbers(splitNumbers(text));
		}
		else if (text.contains("//")) {
			return sum(differentDelimiter(text));
			
		}
		else if(text.contains(",") || (text.contains("\n"))){
			return sum(splitNumbers(text));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

	private static String[] differentDelimiter(String numbers){
		String newDelimiter = numbers.substring(2,3);
    	numbers = numbers.replaceAll("\n","");
    	numbers = numbers.substring(3); 
    	numbers = numbers.replaceAll(newDelimiter,",");

    	return numbers.split(",");
    }

    private static int noNegativeNumbers(String[] numbers){
    	String storeNegativeNumbers = "";

	    for (String number : numbers) {
	            if (toInt(number)< 0) {
	                storeNegativeNumbers += number;
	                storeNegativeNumbers += (", ");
	            }
	    }

	    throw new IllegalArgumentException("Negatives not allowed: " + storeNegativeNumbers);

    }


}