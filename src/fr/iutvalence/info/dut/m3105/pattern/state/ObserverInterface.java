package fr.iutvalence.info.dut.m3105.pattern.state;

public interface ObserverInterface {
	void notifyStateChange(TrafficSignalStateName name);
	void notifyTimeChange();
}
