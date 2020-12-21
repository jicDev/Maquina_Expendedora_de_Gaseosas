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

    public String BuySoda() {
        String brand = this.machine.GetBrandSelected();
        if (this.sodaService.HasStock(brand)) {
            this.sodaService.DecreaseStock(brand);
            this.machine.BuySoda();
        } else {
            this.machine.EmptyStock();
            brand = null;
        }

        return brand;
    }

    public void RetrieveSoda() {
        this.machine.RetrieveSoda();
    }
}
