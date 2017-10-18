package be.ordina.spring.scope;

public class ScopeApp {

    private IncrementService incrementService;

    public void print() {
        incrementService.printValue();
    }

    public void increment() {
        incrementService.increment();
    }

    public void setIncrementService(IncrementService incrementService) {
        this.incrementService = incrementService;
    }
}
