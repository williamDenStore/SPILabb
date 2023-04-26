package org.example.consumer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;

public class ConsumerTest extends TestCase {
    @Test
    public void usingMinusOneInMainShouldFinishTheApplication() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ByteArrayInputStream in = new ByteArrayInputStream("-1".getBytes());
        System.setIn(in);
        String[] args = {"arg1", "arg2"};
        Consumer.main(args);
    }
}