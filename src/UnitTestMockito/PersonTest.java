package InterfaceDemo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by FLK on 2019-03-23.
 */
public class PersonTest {

    private final String mName = "FLK";

    private final String mId = "123";

    private Person mPerson = new Person(mName,mId);


    @Test
    public void testGetName(){
        final String name = mPerson.getName();

        assertEquals(name,mName);
    }

    @Test
    public void testGetId(){
        final String id = mPerson.getId();

        assertEquals(id,mId);
    }

    @Test
    public void testRead(){
        //Arrange
        final IReadable mockIReadable = mock(IReadable.class);
        final String mockContent = "Frank Demos Mockito";

        System.out.println("mockIReadable.getContent() is: " + mockIReadable.getContent());

        given(mockIReadable.getContent()).willReturn(mockContent);

        //Act
        final String result = mPerson.read(mockIReadable);

        //Verify
        assertEquals(result,mockContent);
    }
}