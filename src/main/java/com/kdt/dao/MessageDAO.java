package com.kdt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.ChattingRoomDTO;
import com.kdt.dto.MessageDTO;
import com.kdt.dto.ParticipantDTO;
import com.kdt.dto.RoomInfoDTO;
import com.kdt.dto.RoomProfileDTO;

@Repository
public class MessageDAO {

	@Autowired
	private SqlSession db;
	
	public ChattingRoomDTO createRoom(ChattingRoomDTO dto) {
		db.insert("Message.createRoom", dto);
		System.out.println("Room Seq : " + dto.getSeq());
		return dto;
	}
	
	public int addParticipants(ParticipantDTO dto) {
		return db.insert("Message.setParticipants", dto);
	}
	
	public int initRoom(MessageDTO dto) {
		return db.insert("Message.initRoom", dto);
	}
	
	public List<RoomInfoDTO> getRoomInfo(String id) {
		return db.selectList("Message.selectRoomInfo", id);
	}
	
	public List<Integer> getJoinedRoom(String id) {
		return db.selectList("Message.selectJoinedRoom", id);
	}
	
	public List<RoomProfileDTO> getProfiles(String id) {
		return db.selectList("Message.selectProfiles", id);
	}
	
	public List<MessageDTO> getRecentMessage(String id) {
		return db.selectList("Message.recentMessage", id);
	}
	
	public List<MessageDTO> getMessagesByRoomSeq(String room_seq) {
		return db.selectList("Message.selectByRoomSeq", room_seq);
	}
	
	public String getName(String id) {
		return db.selectOne("Member.selectName", id);
	}
}
