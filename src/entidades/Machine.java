package entidades;

import state.MachineState;
import state.ReadyState;

public class Machine {
    private MachineState state;

    public Machine() {
        this.state = new ReadyState(this);
    }

    public void SetState(MachineState state) {
        System.out.println("From: " + this.state.GetState());
        this.state = state;
        System.out.println("To: " + this.state.GetState());
    }

    public String GetState() {
        return this.state.GetState();
    }

    public void AddCoin() {
        this.state.AddCoin();
    }

    public void ReturnCoin() {
        this.state.ReturnCoin();
    }

    public void SelectSoda(String soda) {
        this.state.SelectSoda(soda);
    }

    public String GetBrandSelected() {
        return this.state.GetBrandSelected();
    }

    public void BuySoda() {
        this.state.BuySoda();
    }

    public void EmptyStock() {
        this.state.EmptyStock();
    }

    public void RetrieveSoda() {
        this.state.RetrieveSoda();
    }
}
