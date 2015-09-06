package net.axelandre42.technologies;

import net.minecraft.block.Block;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class A42T_Logger {
	
	// ----------------------------------------
	// INSTANCE MOTHER FU*****
	
	public static A42T_Logger INSTANCE;
	
	// ----------------------------------------
	// Loader
	
	public static void load(Logger log) {
		INSTANCE = new A42T_Logger(log);
	}
	
	// ----------------------------------------
	// Log4j's Logger
	
	private final Logger log;
	
	// ----------------------------------------
	// Markers
	
	private final Marker markPreInit = MarkerManager.getMarker("Pre-Initialization");
	private final Marker markInit = MarkerManager.getMarker("Initilization");
	private final Marker markPostInit = MarkerManager.getMarker("Post-Initialization");
	
	private final Marker markIngame = MarkerManager.getMarker("Ingame");
	
	private final Marker markBlockInit = MarkerManager.getMarker("Blocks", markPreInit);
	private final Marker markTileEntityInit = MarkerManager.getMarker("TileEntity", markInit);
	private final Marker markRendererInit = MarkerManager.getMarker("Renderer", markInit);
	
	// ----------------------------------------
	// Constructor
	
	public A42T_Logger(Logger log) {
		this.log = log;
	}
	
	// ----------------------------------------
	// Logging
	
	public void logBlockLoad(String name) {
		log.info(markBlockInit, "Loading block : " + name);
	}
	
	public void logTileEntityLoad(String name) {
		log.info(markTileEntityInit, "Loading TileEntity : " + name);
	}
	
	public void logRendererLoad(String name) {
		log.info(markRendererInit, "Loading Renderer : " + name);
	}
	
	public void logPreInitMessage(String message) {
		log.info(markPreInit, message);
	}
	
	public void logInitMessage(String message) {
		log.info(markInit, message);
	}
	
	public void logPostInitMessage(String message) {
		log.info(markPostInit, message);
	}
	
}
