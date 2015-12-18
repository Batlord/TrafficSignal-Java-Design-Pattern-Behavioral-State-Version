package fr.iutvalence.info.dut.m3105.pattern.state;

import java.util.LinkedList;
import java.util.List;

public class TrafficSignal extends Thread implements TrafficSignalContext,
		TrafficSignalUserInterface {
	private TrafficSignalState state;
	private List<ObserverInterface> observers = new LinkedList<>();

	@Override
	public void setTrafficSignalState(TrafficSignalState state) {
		notifyStateChange(state.getName());
		this.state = state;
	}

	private void notifyStateChange(TrafficSignalStateName name) {
		for (ObserverInterface observer : this.observers) {
			observer.notifyStateChange(name);
		}
	}

	public void registerObserver(ObserverInterface ob) {
		this.observers.add(ob);
	}

	public void unregisterObserver(ObserverInterface ob) {
		this.observers.remove(ob);
	}

	@Override
	public void pressButton() {
		this.state.buttonPressed();
	}

	@Override
	public void run() {
		this.setTrafficSignalState(new TrafficSignalGreenState(this));
		while (true) {
			try {
				Thread.sleep(1000);
				this.state.secondEllapsed();
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}
