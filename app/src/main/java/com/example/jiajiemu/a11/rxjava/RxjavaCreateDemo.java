package com.example.jiajiemu.a11.rxjava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by Mjj on 2017/10/6.
 */

public class RxjavaCreateDemo {

    //第一步：（a，b，c都是等价的）
    // a: 创建被观察者：create
    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello");
            subscriber.onNext("Imooc");
            subscriber.onCompleted();
        }
    });

    //b: 通过just方法来创建被观察者
    Observable observableJust = Observable.just("hello", "Imooc");

    //c: 通过from方法来创建被观察者
    String[] parameters = {"hello", "Imooc"};
    Observable observableFrom = Observable.from(parameters);

    //第二步：
    // 创建观察者（决定事件触发的时候，有怎么样的行为）
    Observer<Object> observer = new Observer<Object>() {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Object s) {

        }
    };

    public void doRxjava(){
        //第三步：
        // 订阅（和观察者注册差不多）
        observable.subscribe(observer);
    }

}
