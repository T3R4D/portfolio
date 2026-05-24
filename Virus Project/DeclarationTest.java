import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.*;
import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * Non-assessed unit tests.
 * These tests check whether some of the expected functions have the correct name and signature.
 */
public class DeclarationTest
{
    @Rule
    public Timeout globalTimeout = new Timeout(30000);
    
    private Class<?> doubleArray;
    private Class<?> doubleArray2;
    private Class<?> agentArray;

    /**
     * Constructor for this test class.
     */
    public DeclarationTest()
    {
        doubleArray = (new double[0]).getClass();
        doubleArray2 = (new double[0][0]).getClass();
        agentArray = (new Agent[0]).getClass();
    }
    
    /**
     * helper method to assert that a class is located in the default package
     */
    private void assertDefaultPackage(Class<?> targetClass)
    {
        String msg = targetClass.getName()+" must be in default package";
        if (targetClass.getPackage() != null)
        {
            assertEquals(msg, "", targetClass.getPackage().getName());
        }
    }
    /**
     * helper method to verify the type parameter of a return value
     */
    private void assertReturnTypeParameter(Class<?> targetClass, String methodName, Class typePar, Class... paramType)
    {        
        String fullname = targetClass.getName()+"."+methodName; 
        String tpname = typePar.getName();
        String msg = "return type of "+fullname+" must have type parameter <"+ tpname +">; ";

        try
        {
            Method method = targetClass.getDeclaredMethod(methodName, paramType);
            Type returnType = method.getGenericReturnType();

            if(returnType instanceof ParameterizedType){
                ParameterizedType ptype = (ParameterizedType) returnType;
                Type[] typeArguments = ptype.getActualTypeArguments();
                assertEquals(msg, 1, typeArguments.length);
                assertEquals(msg, typePar, typeArguments[0]);
            }
            else 
            {
                fail(msg);
            }
        }
        catch (NoSuchMethodException e)
        {
            fail("Method "+fullname+" does not exist or has incorrect signature");
        }

    }

    /**
     * helper method for testing whether a (static) function is declared
     */
    private void assertFunctionDeclared(Class<?> targetClass, String methodName, Class returnType, Class... paramType)
    {
        assertDefaultPackage(targetClass);

        String fullname = targetClass.getName()+"."+methodName; 
        try
        {
            Method method = targetClass.getDeclaredMethod(methodName, paramType);

            assertEquals("Return type of "+fullname, returnType, method.getReturnType());

            assertTrue(fullname+" not declared static", Modifier.isStatic(method.getModifiers()) );
            assertFalse(fullname+" must not be declared private", Modifier.isPrivate(method.getModifiers()) );
        }
        catch (NoSuchMethodException e)
        {
            fail("Function "+fullname+" does not exist or has incorrect signature");
        }                

    }

    /**
     * helper method for testing whether a method is declared
     */
    private void assertMethodDeclared(Class<?> targetClass, String methodName, Class returnType, Class... paramType)
    {
        assertDefaultPackage(targetClass);

        String fullname = targetClass.getName()+"."+methodName; 
        try
        {
            Method method = targetClass.getDeclaredMethod(methodName, paramType);

            assertEquals("Return type of "+fullname, returnType, method.getReturnType());

            assertFalse(fullname+" must not be declared static", Modifier.isStatic(method.getModifiers()) );
            assertFalse(fullname+" must not be declared private", Modifier.isPrivate(method.getModifiers()) );
        }
        catch (NoSuchMethodException e)
        {
            fail("Method "+fullname+" does not exist or has incorrect signature");
        }                

    }

    /**
     * helper method for testing whether a constructor is declared
     */
    private void assertConstructorDeclared(Class<?> targetClass, Class... paramType)
    {
        assertDefaultPackage(targetClass);

        String fullname = "Constructor in "+targetClass.getName(); 
        try
        {
            Constructor constructor = targetClass.getConstructor(paramType);

            assertFalse(fullname+" must not be declared private", Modifier.isPrivate(constructor.getModifiers()) );
        }
        catch (NoSuchMethodException e)
        {
            fail(fullname+" does not exist or has incorrect signature");
        }    
    }

    /**
     * helper method for testing whether *no* constructor is declared 
     * (for composite data types)
     */
    private void assertNoConstructorDeclared(Class<?> targetClass)
    {
        assertDefaultPackage(targetClass);

        try
        {
            Constructor constructor = targetClass.getDeclaredConstructor(new Class[]{});
            
            String msg = "Default constructor in "+targetClass.getName()+" must not be overridden";
            assertFalse(msg, Modifier.isPrivate(constructor.getModifiers()) );
        }
        catch (NoSuchMethodException e)
        {
            // default constructor has been overridden by custom constructor with different signature
            fail(targetClass.getName()+" must not have non-default constructors");
        }    
        
        boolean hasExtraConstructors = targetClass.getConstructors().length > 1;

        String msg = targetClass.getName() + " must not have non-default constructors";
        assertFalse(msg, hasExtraConstructors);
    }

    /**
     * helper method for testing whether a field is declared
     */
    private void assertFieldDeclared(Class<?> targetClass, String fieldName, Class type)
    {
        assertDefaultPackage(targetClass);

        String fullname = targetClass.getName()+"."+fieldName; 
        try
        {
            Field field = targetClass.getDeclaredField(fieldName);

            assertEquals("Type of field "+fullname, type, field.getType());

            assertFalse(fullname+" must not be declared static", Modifier.isStatic(field.getModifiers()) );
            assertFalse(fullname+" must not be declared private", Modifier.isPrivate(field.getModifiers()) );
        }
        catch (NoSuchFieldException e)
        {
            fail("Field "+fullname+" does not exist");
        }      
    }

    /**
     * helper method for testing whether a class is a subclass of another one
     */
    private void assertSubclassOf(Class<?> targetClass, Class<?> superClass)
    {
        assertDefaultPackage(targetClass);

        String msg = "Checking whether "+targetClass.getName()+ " is a subclass of "+superClass.getName();
        assertTrue(msg, superClass.isAssignableFrom(targetClass));
    }

    /**
     * Checks the composite data type "Agent".
     */
    @Test
    public void agentCompositeDatatypeTest()
    {    
        assertNoConstructorDeclared(Agent.class);
        assertFieldDeclared(Agent.class, "x", int.class);
        assertFieldDeclared(Agent.class, "y", int.class);
        assertFieldDeclared(Agent.class, "direction", int.class);
        assertFieldDeclared(Agent.class, "timeAfterInfection", int.class);
        
    }

    /**
     * Checks whether the function "isInfected" is declared correctly.
     */
    @Test
    public void isInfectedDeclaredTest()
    {    
        assertFunctionDeclared(AgentActions.class, "isInfected", boolean.class, Agent.class);
    }

    /**
     * Checks whether the function "isInfectious" is declared correctly.
     */
    @Test
    public void isInfectiousDeclaredTest()
    {    
        assertFunctionDeclared(AgentActions.class, "isInfectious", boolean.class, Agent.class);
    }


    /**
     * Checks whether the function"isInfectable" is declared correctly.
     */
    @Test
    public void isInfectableDeclaredTest()
    {    
        assertFunctionDeclared(AgentActions.class, "isInfectable", boolean.class, Agent.class);
    }

    /**
     * Checks whether the procedure "move" is declared correctly.
     */
    @Test
    public void moveDeclaredTest()
    {    
        assertFunctionDeclared(AgentActions.class, "move", void.class, Agent.class);
    }

    /**
     * Checks whether the procedure "move" is declared correctly.
     */
    @Test
    public void timeStepDeclaredTest()
    {    
        assertFunctionDeclared(AgentActions.class, "timeStep", void.class, Agent.class);
    }

    /**
     * Checks whether the procedure "move" is declared correctly.
     */
    @Test
    public void infectDeclaredTest()
    {    
        assertFunctionDeclared(AgentActions.class, "infect", void.class, Agent.class);
    }


    /**
     * Checks whether the function "countInfected" is declared correctly.
     */
    @Test
    public void countInfectedDeclaredTest()
    {    
        assertFunctionDeclared(Simulator.class, "countInfected", int.class, agentArray);
    }

    /**
     * Checks whether the function "randomAgents" is declared correctly.
     */
    @Test
    public void randomAgentsDeclaredTest()
    {    
        assertFunctionDeclared(Simulator.class, "randomAgents", agentArray, int.class, double.class);
    }

    /**
     * Checks whether the procedure "oneRound" is declared correctly.
     */
    @Test
    public void oneRoundDeclaredTest()
    {    
        assertFunctionDeclared(Simulator.class, "oneRound", void.class, agentArray);
    }

    /**
     * Checks whether the procedure "runSimulation" is declared correctly.
     */
    @Test
    public void runSimulationDeclaredTest()
    {    
        assertFunctionDeclared(Simulator.class, "runSimulation", void.class, int.class, double.class, int.class, String.class);
    }

}
