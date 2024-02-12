package View;

import java.util.List;

import Controller.Controller;
import Model.MyException;
import Model.PrgState;
import Model.ADTs.MyIList;
import Model.Values.IValue;
import Repository.IRepository;
import Repository.MemoryRepo;


public class RunExample extends Command {
    private PrgState prg;
    private String LogFile;
    private int index;

    public RunExample(String key, String desc, PrgState prg, String logFile) {
        super(key, desc);
        this.prg = prg;
        this.LogFile = logFile;
    }

    @Override
    public void execute() {
        try {
                prg.reset();
                List<PrgState> prgList = List.of(this.prg);
                IRepository repo = new MemoryRepo((List<PrgState>) prgList, LogFile+"_"+index+".txt");
                index++;
                Controller ctrl = new Controller(repo);
                ctrl.executeAll(prg);
                MyIList<IValue> out = prg.getOut();
                System.out.println(out.toString());

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
