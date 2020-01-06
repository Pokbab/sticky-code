package test.lib;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;
import lombok.SneakyThrows;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.io.Flushable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

public class RxJava2Test {

	/**
	 * BackpressureStrategy 설명
	 *   Missing	배압을 적용안한다. 후에 onBackpressureXXX()등으로 컨트롤이 가능하다.
	 * 	 Error		MissingBackpressureException 발생시 에러를 발생시킨다.
	 * 	 Buffer		onBackpressureBuffer() 와 같은 형태
	 *   Lastest	다운스트림이 받을때까지 마지막꺼만 유지를 한다.
	 */
	@Test
	public void testCreating_create() {
		Flowable.create(emitter -> {

			LocalDate begin = LocalDate.now();
			LocalDate end = begin.plusDays(1);

			while (begin.isBefore(LocalDate.now().plusMonths(1))) {
				emitter.onNext(begin);

				begin = end;
				end = end.plusDays(1);
			}

			emitter.onComplete();
		}, BackpressureStrategy.BUFFER)
				.doOnNext(localDate -> System.out.println(localDate))
				.doOnComplete(() -> System.out.println("완료"))
				.test();
	}

	@Test
	public void testCreating_defer() {
//		System.out.println("시작: no defer");
//
		Flowable.range(1, 10)
				.doOnNext(n -> System.out.println(n + ": no defer"))
//				.subscribeOn(Schedulers.io())
				.test();
//
//		System.out.println("종료: no defer");
//
//		System.out.println("시작: defer");
//
//		Flowable.defer(() -> Flowable.range(1, 10))
//				.doOnNext(n -> System.out.println(n + ": defer"))
//				.subscribeOn(Schedulers.io())
//				.test();
//
//		System.out.println("종료: defer");


		System.out.println("시작: defer");

		Flowable.defer(() -> Flowable.fromIterable(getTestNumbers()))
//				.subscribeOn(Schedulers.io())
				.doOnNext(dateTime -> System.out.println(dateTime))
				.doOnComplete(() -> System.out.println("완료"))
				.doOnError(e -> System.out.println("에러"))
				.test();

		System.out.println("종료: defer");

//		testSubscriber.assertValue()
	}

	@SneakyThrows
	private List<Integer> getTestNumbers() {
		Thread.sleep(3000);
		return Arrays.asList(1, 2, 3, 4, 5);
	}

}
