package com.krestone.savealife.domain.usecases;


import com.krestone.savealife.data.entities.responses.MapObjectsEntity;
import com.krestone.savealife.data.repository.MapRepository;
import com.krestone.savealife.domain.schedulers.ObserveOn;
import com.krestone.savealife.domain.schedulers.SubscribeOn;
import com.krestone.savealife.domain.usecases.base.UseCaseStream;

import rx.Observable;

public class GetMapObjectsUseCase extends UseCaseStream<MapObjectsEntity> {

    private MapRepository mapRepository;

    private int updateIntervalSec;

    private double updateArea;

    public GetMapObjectsUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, MapRepository mapRepository) {
        super(subscribeOn, observeOn);
        this.mapRepository = mapRepository;
    }

    @Override
    protected Observable<MapObjectsEntity> getUseCaseObservable() {
        mapRepository.setUpdateArea(updateArea);
        mapRepository.setUpdateIntervalInSec(updateIntervalSec);
        return mapRepository.getMapObjects();
    }

    public void setUpdateIntervalSec(int updateIntervalSec) {
        this.updateIntervalSec = updateIntervalSec;
    }

    public void setUpdateArea(double updateArea) {
        this.updateArea = updateArea;
    }

    public int getUpdateIntervalSec() {
        return updateIntervalSec;
    }

    public double getUpdateArea() {
        return updateArea;
    }
}
