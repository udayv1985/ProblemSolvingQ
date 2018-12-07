package com.uday.oops.design.atc;

public interface AirTrafficController {

	void process(AirplaneAction request);

	void call(Airplane airplane);

}
