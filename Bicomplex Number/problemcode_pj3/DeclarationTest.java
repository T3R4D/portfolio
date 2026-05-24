import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import java.lang.reflect.*;

/**
 * Mathematical Skills II, Programming (2020/21);
 * Project 3.
 * 
 * Non-assessed unit tests.
 * 
 * These tests check whether some of the expected functions have the correct name and signature.
 */
public class DeclarationTest
{
    private Class<?> bicomplexArray;

    /**
     * Constructor for this test class.
     */
    public DeclarationTest()
    {
        bicomplexArray = (new BicomplexNumber[0]).getClass();
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
    private void testFunctionDeclared(Class<?> targetClass, String methodName, Class returnType, Class... paramType)
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
    private void testMethodDeclared(Class<?> targetClass, String methodName, Class returnType, Class... paramType)
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
    private void testConstructorDeclared(Class<?> targetClass, Class... paramType)
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
    private void testNoConstructorDeclared(Class<?> targetClass)
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
    private void testFieldDeclared(Class<?> targetClass, String fieldName, Class type)
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
    private void testSubclassOf(Class<?> targetClass, Class<?> superClass)
    {
        assertDefaultPackage(targetClass);

        String msg = "Checking whether "+targetClass.getName()+ " is a subclass of "+superClass.getName();
        assertTrue(msg, superClass.isAssignableFrom(targetClass));
    }

    /**
     * Tests whether the constructors of BicomplexNumber are declared correctly.
     */
    @Test
    public void bicomplexConstructorDeclaredTest()
    {
        testConstructorDeclared(BicomplexNumber.class, double.class, double.class, double.class, double.class);
        testConstructorDeclared(BicomplexNumber.class, ComplexNumber.class, ComplexNumber.class);
    }

    /**
     * Tests whether the getX methods for coefficients of a BicomplexNumber are declared.
     */
    @Test
    public void getABCDDeclaredTest()
    {
        testMethodDeclared(BicomplexNumber.class, "getA", double.class);
        testMethodDeclared(BicomplexNumber.class, "getB", double.class);
        testMethodDeclared(BicomplexNumber.class, "getC", double.class);
        testMethodDeclared(BicomplexNumber.class, "getD", double.class);
    }

    /**
     * Tests whether the method abs() is declared.
     */
    @Test
    public void absDeclaredTest()
    {
        testMethodDeclared(BicomplexNumber.class, "abs", double.class);
    }

    /**
     * Tests whether the method for the square complex norm is declared.
     */
    @Test
    public void scnDeclaredTest()
    {
        testMethodDeclared(BicomplexNumber.class, "squareComplexNorm", ComplexNumber.class);
    }

    /**
     * Tests whether the method negate() is declared.
     */
    @Test
    public void negateDeclaredTest()
    {
        testMethodDeclared(BicomplexNumber.class, "negate", BicomplexNumber.class);
    }

    /**
     * Tests whether the method conjugate() is declared.
     */
    @Test
    public void conjugateDeclaredTest()
    {
        testMethodDeclared(BicomplexNumber.class, "conjugate", BicomplexNumber.class);
    }

    /**
     * Tests whether the method add() is declared.
     */
    @Test
    public void addDeclaredTest()
    {
        testMethodDeclared(BicomplexNumber.class, "add", BicomplexNumber.class, BicomplexNumber.class);
    }

    /**
     * Tests whether the method subtract() is declared.
     */
    @Test
    public void subtractDeclaredTest()
    {
        testMethodDeclared(BicomplexNumber.class, "subtract", BicomplexNumber.class, BicomplexNumber.class);
    }

    /**
     * Tests whether the method multiply() is declared.
     */
    @Test
    public void multiplyDeclaredTest()
    {
        testMethodDeclared(BicomplexNumber.class, "multiply", BicomplexNumber.class, BicomplexNumber.class);
    }

    /**
     * Tests whether the method invert() is declared.
     */
    @Test
    public void invertDeclaredTest()
    {
        testMethodDeclared(BicomplexNumber.class, "invert", BicomplexNumber.class);
    }

    /**
     * Tests whether the method divide() is declared.
     */
    @Test
    public void divideDeclaredTest()
    {
        testMethodDeclared(BicomplexNumber.class, "divide", BicomplexNumber.class, BicomplexNumber.class);
    }

    /**
     * Tests whether the method exp() is declared.
     */
    @Test
    public void expDeclaredTest()
    {
        testMethodDeclared(BicomplexNumber.class, "exp", BicomplexNumber.class);
    }

    /**
     * Tests whether the (only) method valueAt() of the class BicomplexFunction is declared.
     */
    @Test
    public void bcfValueAtDeclaredTest()
    {
        testMethodDeclared(BicomplexFunction.class, "valueAt", BicomplexNumber.class, BicomplexNumber.class);
    }

    /**
     * Tests whether the constructor the class BicomplexPolynomial is declared correctly.
     */
    @Test
    public void bcPolyConstructorDeclaredTest()
    {
        testConstructorDeclared(BicomplexPolynomial.class, bicomplexArray);
    }

    /**
     * Tests whether the function secantMethod is declared.
     */
    @Test
    public void secantMethodDeclaredTest()
    {
        testFunctionDeclared(ZeroFinder.class, "secantMethod", BicomplexNumber.class, BicomplexFunction.class, BicomplexNumber.class, BicomplexNumber.class);
    }

    /**
     * Tests whether the function findAllZeros is declared.
     */
    @Test
    public void findAllZerosDeclaredTest()
    {
        testFunctionDeclared(ZeroFinder.class, "findAllZeros", List.class, BicomplexFunction.class, double.class);
        assertReturnTypeParameter(ZeroFinder.class, "findAllZeros", BicomplexNumber.class, BicomplexFunction.class, double.class);
    }

    /**
     * Tests whether the function findSolution is declared.
     */
    @Test
    public void findSolutionDeclaredTest()
    {
        testFunctionDeclared(ZeroFinder.class, "findSolution", BicomplexNumber.class, BicomplexNumber.class);
    }

}
