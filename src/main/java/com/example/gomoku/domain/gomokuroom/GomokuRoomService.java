package com.example.gomoku.domain.gomokuroom;

import static com.example.gomoku.domain.gomokuroom.dto.request.GomokuRoomCreateReq.*;

import com.example.gomoku.domain.gomokuroom.dto.request.GomokuRoomCreateReq;
import com.example.gomoku.domain.gomokuroom.dto.response.GomokuRoomCreateRes;
import com.example.gomoku.domain.gomokuroom.dto.response.GomokuRoomListRes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GomokuRoomService {

  private final GomokuRoomRepository gomokuRoomRepository;

  public GomokuRoomService(GomokuRoomRepository gomokuRoomRepository) {
    this.gomokuRoomRepository = gomokuRoomRepository;
  }

  @Transactional
  public GomokuRoomCreateRes createGomokuRoom(GomokuRoomCreateReq gomokuRoomCreateReq) {
    GomokuRoom newGomokuRoom = toGomokuRoom(gomokuRoomCreateReq);
    GomokuRoom savedGomokuRoom = gomokuRoomRepository.save(newGomokuRoom);
    return new GomokuRoomCreateRes(savedGomokuRoom.getRoomId(), savedGomokuRoom.getRoomName());
  }

  @Transactional
  public GomokuRoomListRes findGomokuRoom() {
    List<GomokuRoom> allRoom = gomokuRoomRepository.findAll();
    return new GomokuRoomListRes(allRoom);
  }
}
