package com.github.antonioazambuja.noxus.resources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchEventDto {
	@JsonProperty("laneType")
	private String LaneType;
	@JsonProperty("skillSlot")
	private Integer SkillSlot;
	@JsonProperty("ascendedType")
	private String AscendedType;
	@JsonProperty("creatorId")
	private Integer CreatorId;
	@JsonProperty("afterId")
	private Integer AfterId;
	@JsonProperty("eventType")
	private String EventType;
	@JsonProperty("type")
	private String Type;
	@JsonProperty("levelUpType")
	private String LevelUpType;
	@JsonProperty("wardType")
	private String WardType;
	@JsonProperty("participantId")
	private Integer ParticipantId;
	@JsonProperty("towerType")
	private String TowerType;
	@JsonProperty("itemId")
	private Integer ItemId;
	@JsonProperty("beforeId")
	private Integer BeforeId;
	@JsonProperty("pointCaptured")
	private String PointCaptured;
	@JsonProperty("monsterType")
	private String MonsterType;
	@JsonProperty("monsterSubType")
	private String MonsterSubType;
	@JsonProperty("teamId")
	private Integer TeamId;
	@JsonProperty("position")
	private MatchPositionDto Position;
	@JsonProperty("killerId")
	private Integer KillerId;
	@JsonProperty("timestamp")
	private Long Timestamp;
	@JsonProperty("assistingParticipantIds")
	private List<Integer> AssistingParticipantIds;
	@JsonProperty("buildingType")
	private String BuildingType;
	@JsonProperty("victimId")
	private Integer VictimId;

	public MatchEventDto() {}

	public MatchEventDto(String laneType, Integer skillSlot, String ascendedType, Integer creatorId, Integer afterId,
			String eventType, String type, String levelUpType, String wardType, Integer participantId, String towerType,
			Integer itemId, Integer beforeId, String pointCaptured, String monsterType, String monsterSubType,
			Integer teamId, MatchPositionDto position, Integer killerId, Long timestamp,
			List<Integer> assistingParticipantIds, String buildingType, Integer victimId) {
		LaneType = laneType;
		SkillSlot = skillSlot;
		AscendedType = ascendedType;
		CreatorId = creatorId;
		AfterId = afterId;
		EventType = eventType;
		Type = type;
		LevelUpType = levelUpType;
		WardType = wardType;
		ParticipantId = participantId;
		TowerType = towerType;
		ItemId = itemId;
		BeforeId = beforeId;
		PointCaptured = pointCaptured;
		MonsterType = monsterType;
		MonsterSubType = monsterSubType;
		TeamId = teamId;
		Position = position;
		KillerId = killerId;
		Timestamp = timestamp;
		AssistingParticipantIds = assistingParticipantIds;
		BuildingType = buildingType;
		VictimId = victimId;
	}

	public String getLaneType() {
		return LaneType;
	}

	public void setLaneType(String laneType) {
		LaneType = laneType;
	}

	public Integer getSkillSlot() {
		return SkillSlot;
	}

	public void setSkillSlot(Integer skillSlot) {
		SkillSlot = skillSlot;
	}

	public String getAscendedType() {
		return AscendedType;
	}

	public void setAscendedType(String ascendedType) {
		AscendedType = ascendedType;
	}

	public Integer getCreatorId() {
		return CreatorId;
	}

	public void setCreatorId(Integer creatorId) {
		CreatorId = creatorId;
	}

	public Integer getAfterId() {
		return AfterId;
	}

	public void setAfterId(Integer afterId) {
		AfterId = afterId;
	}

	public String getEventType() {
		return EventType;
	}

	public void setEventType(String eventType) {
		EventType = eventType;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getLevelUpType() {
		return LevelUpType;
	}

	public void setLevelUpType(String levelUpType) {
		LevelUpType = levelUpType;
	}

	public String getWardType() {
		return WardType;
	}

	public void setWardType(String wardType) {
		WardType = wardType;
	}

	public Integer getParticipantId() {
		return ParticipantId;
	}

	public void setParticipantId(Integer participantId) {
		ParticipantId = participantId;
	}

	public String getTowerType() {
		return TowerType;
	}

	public void setTowerType(String towerType) {
		TowerType = towerType;
	}

	public Integer getItemId() {
		return ItemId;
	}

	public void setItemId(Integer itemId) {
		ItemId = itemId;
	}

	public Integer getBeforeId() {
		return BeforeId;
	}

	public void setBeforeId(Integer beforeId) {
		BeforeId = beforeId;
	}

	public String getPointCaptured() {
		return PointCaptured;
	}

	public void setPointCaptured(String pointCaptured) {
		PointCaptured = pointCaptured;
	}

	public String getMonsterType() {
		return MonsterType;
	}

	public void setMonsterType(String monsterType) {
		MonsterType = monsterType;
	}

	public String getMonsterSubType() {
		return MonsterSubType;
	}

	public void setMonsterSubType(String monsterSubType) {
		MonsterSubType = monsterSubType;
	}

	public Integer getTeamId() {
		return TeamId;
	}

	public void setTeamId(Integer teamId) {
		TeamId = teamId;
	}

	public MatchPositionDto getPosition() {
		return Position;
	}

	public void setPosition(MatchPositionDto position) {
		Position = position;
	}

	public Integer getKillerId() {
		return KillerId;
	}

	public void setKillerId(Integer killerId) {
		KillerId = killerId;
	}

	public Long getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Long timestamp) {
		Timestamp = timestamp;
	}

	public List<Integer> getAssistingParticipantIds() {
		return AssistingParticipantIds;
	}

	public void setAssistingParticipantIds(List<Integer> assistingParticipantIds) {
		AssistingParticipantIds = assistingParticipantIds;
	}

	public String getBuildingType() {
		return BuildingType;
	}

	public void setBuildingType(String buildingType) {
		BuildingType = buildingType;
	}

	public Integer getVictimId() {
		return VictimId;
	}

	public void setVictimId(Integer victimId) {
		VictimId = victimId;
	}

}
