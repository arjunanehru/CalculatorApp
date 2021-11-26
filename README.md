# CalculatorApp

Implementation:
 - The application will take the input from the command line. Once the user provides input, system will do some preprocessings to perorm the operation. Main class - Calculator will be displaying the various operations and does initial validation to check whether the input is valid.
 - If the input is valid, Calculate.performOperation will be invoked to perform the pre-processings, precedence checks, operator checks. While checking the precedence - 2 stacks will be initiallized[OperatorStack & OperandStack]. Based on the priorities, the input will be spiltted and pushed into the stacks. 
 - Compute.invokeCalculation will be called to calculate the data received. An interface CalcService will be having the operations that can be perormed. Also an object will be created from Compute class for the interface and the calculation will be happening.
 - Also have implemented a separate class to store the constant variable, a Util class where the precedence, operator check will be happening. And a logger class to capture the log for debugging purpose.
 - Various testcases has been exceuted in CalcTest.
 
Execution:
Have placed an executable jar file "target" folder. Please download that and follow the below instruction:
- Place the file in a folder and open command prompt/console
- Execute the below command:
	java -jar Calculator.jar
- Feed the input in command line. Result will be shown after calculation
- Incase of any errors - we can verify the application.log generated in the same folder.
