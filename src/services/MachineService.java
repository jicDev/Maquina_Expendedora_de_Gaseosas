package services;

import entidades.Machine;

public class MachineService {
    private Machine machine;
    private SodaService sodaService;

    public MachineService(SodaService sodaService) {
        this.machine = new Machine();
        this.sodaService = sodaService;
    }

    public String GetState() {
        return this.machine.GetState();
    }

    public void AddCoin() {
        this.machine.AddCoin();
    }

    public void ReturnCoin() {
        this.machine.ReturnCoin();
    }

    public void SelectSoda(String soda) {
        this.machine.SelectSoda(soda);
    }

    public void BuySoda() {
        if (this.sodaService.HasStock(this.machine.GetBrandSelected())) {
            this.sodaService.DecreaseStock(this.machine.GetBrandSelected());
            this.machine.BuySoda();
        } else {
            this.machine.EmptyStock();
        }
    }

    public void RetrieveSoda() {
        this.machine.RetrieveSoda();
    }
}
