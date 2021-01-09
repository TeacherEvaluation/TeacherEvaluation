package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.annotation.NonNull;

import java.util.List;

@Dao
public interface PeerReviewDao {
    @Query("select * from PeerReview")
    List<PeerReview>getAll();
    @Query("select * from peerreview where ted_id=:ted_Id and ting_id=:ting_Id and tg_id =:tg_Id")
    PeerReview getPeerReview(@NonNull String ted_Id, @NonNull String ting_Id, long tg_Id);
    @Insert
    void insertPeerReview(PeerReview...peerReviews);
    @Delete
    void deletePeerReview(PeerReview...peerReviews);
    @Update
    void updatePeerReview(PeerReview...peerReviews);
}
