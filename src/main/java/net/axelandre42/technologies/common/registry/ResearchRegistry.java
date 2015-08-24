package net.axelandre42.technologies.common.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.axelandre42.technologies.api.research.IBlueprint;
import net.axelandre42.technologies.api.research.IProperty;
import net.axelandre42.technologies.api.research.IResearch;
import net.axelandre42.technologies.api.research.IResearchRegistry;

public class ResearchRegistry implements IResearchRegistry {

	private Map<String, IResearch> researches = new HashMap<String, IResearch>();
	private Map<String, IProperty> properties = new HashMap<String, IProperty>();
	private Map<String, IBlueprint> blueprints = new HashMap<String, IBlueprint>();
	
	@Override
	public void registerResearch(IResearch research) {
		researches.put(research.getUnlocalizedName(), research);
	}

	@Override
	public void registerProperty(IProperty property) {
		properties.put(property.getUnlocalizedName(), property);
	}

	@Override
	public void registerBlueprint(IBlueprint blueprint) {
		blueprints.put(blueprint.getUnlocalizedName(), blueprint);
	}

}
