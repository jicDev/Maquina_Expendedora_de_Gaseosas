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

    public String AddCoin() {
        this.state.AddCoin();
        return this.state.GetState();
    }

    public String ReturnCoin() {
        this.state.ReturnCoin();
        return this.state.GetState();
    }

    public String SelectSoda(String soda) {
        this.state.SelectSoda(soda);
        return this.state.GetState();
    }

    public String BuySoda() {
        this.state.BuySoda();
        return this.state.GetState();
    }

    public String RetrieveSoda() {
        this.state.RetrieveSoda();
        return this.state.GetState();
    }
}
