package fr.iutvalence.info.dut.m3105.pattern.state;

public class Observer implements ObserverInterface {

	@Override
	public void notifyStateChange(TrafficSignalStateName name) {
		System.out.println("Traffic signal state is " + name);
	}

	@Override
	public void notifyTimeChange() {
		// TODO Auto-generated method stub
		
	}

}
