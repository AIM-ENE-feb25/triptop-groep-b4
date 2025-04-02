package triptop.groepB4.service;

import triptop.groepB4.domein.Hotel;
import triptop.groepB4.domein.Vlucht;

import java.util.ArrayList;

public class VluchtActionManager implements VluchtActionHandler{

    private ArrayList<Vlucht> vluchtList = new ArrayList<>();

    @Override
    public void BookFlight(Vlucht vlucht) {
        vlucht.BookFlight();
    }

    @Override
    public void PayFlightBooking(Vlucht vlucht) {
        vlucht.PayFlightBooking();
    }

    @Override
    public void CancelFlightBooking(Vlucht vlucht) {
        vlucht.CancelFlightBooking();
    }

    @Override
    public void VoerVluchtUit(Vlucht vlucht) {
        vlucht.VoerVluchtUit();
    }

    @Override
    public Vlucht getVlucht(int id) {
        for (Vlucht vlucht : vluchtList){
            if(vlucht.getFlightId() == id){
                return vlucht;
            }
        }
        return null;
    }

    @Override
    public void NewVlucht(Vlucht vlucht) {
        vluchtList.add(vlucht);
    }
}
