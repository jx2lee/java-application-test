package com.jx2lee.junitbasic.extension;

import com.jx2lee.junitbasic.customtag.DevTest;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;

public class FindDevTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private static final long THRESHOLD = 1000L;

    @Override
    public void beforeTestExecution(ExtensionContext context) {

        ExtensionContext.Store store = getStore(context);
        store.put("START TIME", System.currentTimeMillis());

    }

    @Override
    public void afterTestExecution(ExtensionContext context) {

        Method requiredTestMethod = context.getRequiredTestMethod();
        DevTest annotation = requiredTestMethod.getAnnotation(DevTest.class);

        ExtensionContext.Store store = getStore(context);

        long start_time = store.remove("START TIME", long.class);
        long duration = System.currentTimeMillis() - start_time;

        if (duration > THRESHOLD && annotation == null) {
            System.out.printf("please consider mark method [%s] with @DevTest.\n", requiredTestMethod.getName());
        }
    }

    private ExtensionContext.Store getStore(ExtensionContext context) {
        String testClassName = context.getRequiredTestClass().getName();
        String testMethodName = context.getRequiredTestMethod().getName();
        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(testClassName, testMethodName));
        return store;
    }
}
