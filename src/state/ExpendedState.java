package state;

import entidades.Machine;

public class ExpendedState implements MachineState {
    private final Machine machine;

    public ExpendedState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void AddCoin() {

    }

    @Override
    public void ReturnCoin() {

    }

    @Override
    public void SelectSoda(String soda) {

    }

    @Override
    public void BuySoda() {

    }

    @Override
    public void RetrieveSoda() {
        this.machine.SetState(new ReadyState(this.machine));
    }

    @Override
    public String GetState() {
        return "LATA_EXPENDIDA";
    }
}
