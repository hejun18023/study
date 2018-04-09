package rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

import java.util.stream.IntStream;

/**
 * Created by hejun on 2018/3/5.
 */
public class ReactiveJava {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                IntStream.range(0,5).forEach(i->{
                    subscriber.onNext(i);
                });
                subscriber.onCompleted();
            }
        });

        Subscription subscription = observable.subscribe(integer -> {
            System.out.println("onNext : " + integer);
        }, e ->{
            System.out.println("exception " + e.getMessage());
        },() ->{
            System.out.println("finished!");
        });

        System.out.println(observable.count());
    }

}
