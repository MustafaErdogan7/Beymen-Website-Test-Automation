import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Logs implements TestWatcher {
    Log log=new Log();
    /*@Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }*/

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
        String functionName=context.getDisplayName();
        log.info(functionName+" testing is PASSED");

    }

    /*@Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }*/

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testFailed(context, cause);
        String functionName=context.getDisplayName();
        String why=cause.getMessage();
        log.error(functionName+" testing is FAILED because of "+why);
    }
}
