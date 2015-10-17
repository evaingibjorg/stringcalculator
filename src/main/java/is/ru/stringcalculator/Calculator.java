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
		    if(toInt(number) <= 1000)
		{
		    total += toInt(number);
		}
		}
		return total;
    }

	private static String[] differentDelimiter(String numbers){
		int countDelimiters = 0;
		countDelimiters = numbers.split("]").length - 1;
		
		if(countDelimiters > 1)
		{

			numbers = numbers.replaceAll("\n","");

			int frontOfDelimiter;
			int endOfDelimiter;
			String newDelimiter;

			for(int i = 0; i < countDelimiters; i++)
			{
			frontOfDelimiter = numbers.indexOf("[");
			endOfDelimiter = numbers.indexOf("]");
			newDelimiter = numbers.substring(frontOfDelimiter + 1,endOfDelimiter);

	    	numbers = numbers.substring(endOfDelimiter + 1);
	    	numbers = numbers.replace(newDelimiter,",");

	    	}
    	}

		else if(numbers.contains ("[") && numbers.contains("]")){
    	int endOfDelimiter = numbers.indexOf("]");
    	String newDelimiter = numbers.substring(3,endOfDelimiter);

    	numbers = numbers.replace(newDelimiter,",");
    	numbers = numbers.substring(endOfDelimiter);
    	}

    	else{
		String newDelimiter = numbers.substring(2,3);

    	numbers = numbers.replaceAll("\n","");
    	numbers = numbers.substring(3); 
    	numbers = numbers.replaceAll(newDelimiter,",");
    	}

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