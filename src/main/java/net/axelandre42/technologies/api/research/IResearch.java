package net.axelandre42.technologies.api.research;

import java.util.List;

public interface IResearch {
	/**
	 * The researches need properties, this is a method to define that.
	 * @return A list of needed properties.
	 */
	List<IProperty> getNeededProperties();
	
	/**
	 * The display name of the research needs to be localized, you need to define the unlocalized name here.
	 * @return The unlocalized name.
	 */
	String getUnlocalizedName();
	
	/**
	 * The research unlocks some blueprints, define them there.
	 * @return a List with all unlocked blueprints
	 */
	List<IBlueprint> getUnlockedBlueprints();
}
