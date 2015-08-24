package net.axelandre42.technologies.common.init;

import net.axelandre42.technologies.api.Axelandre42TechnologiesAPI;
import net.axelandre42.technologies.common.registry.ResearchRegistry;

public class Registries {
	public static ResearchRegistry researchRegistry;
	
	public static void construct() {
		researchRegistry = new ResearchRegistry();
	}
	
	public static void addToAPI() {
		Axelandre42TechnologiesAPI.researchRegistry = researchRegistry;
	}
}
