package Controller;

import java.util.List;

import Model.MyException;
import Model.PrgState;

public interface IController {
    int getNextId();
    void executeAll(PrgState state) throws MyException;
    PrgState GetCrtPrg() throws MyException;
    void WriteToFile(String s) throws MyException;
    void oneStepForAllPrg(List<PrgState> prgList) throws MyException, InterruptedException;
}
