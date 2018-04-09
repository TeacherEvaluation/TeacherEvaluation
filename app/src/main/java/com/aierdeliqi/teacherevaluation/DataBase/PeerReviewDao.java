package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PeerReviewDao {
    @Query("select * from PeerReview")
    List<PeerReview>getAll();
    @Query("select * from peerreview where ted_id=:ted_Id and ting_id=:ting_Id and tg_id =:tg_Id")
    PeerReview getPeerReview(long ted_Id,long ting_Id,long tg_Id);
    @Insert
    void insertPeerReview(PeerReview...peerReviews);
    @Delete
    void deletePeerReview(PeerReview...peerReviews);
    @Update
    void updatePeerReview(PeerReview...peerReviews);
}
