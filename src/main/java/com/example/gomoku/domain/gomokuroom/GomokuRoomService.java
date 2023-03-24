package com.example.gomoku.domain.gomokuroom;

import static com.example.gomoku.domain.gomokuroom.dto.request.GomokuRoomCreateReq.*;

import com.example.gomoku.domain.gomokuroom.dto.request.GomokuRoomCreateReq;
import com.example.gomoku.domain.gomokuroom.dto.response.GomokuRoomCreateRes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    return new GomokuRoomCreateRes(savedGomokuRoom.getRoomId());
  }
}
