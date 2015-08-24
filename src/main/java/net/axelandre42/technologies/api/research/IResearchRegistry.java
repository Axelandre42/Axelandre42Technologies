package net.axelandre42.technologies.api.research;

public interface IResearchRegistry {
	void registerResearch(IResearch research);
	
	void registerProperty(IProperty property);
	
	void registerBlueprint(IBlueprint blueprint);
}
