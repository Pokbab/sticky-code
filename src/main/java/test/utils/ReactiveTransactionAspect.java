package test.utils;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Method;

@Aspect
@Component
public class ReactiveTransactionAspect {

//	@Autowired
//	private TransactionService transactionService;

	@Pointcut("@annotation(test.utils.ReactiveTransactional)")
	public void reactiveTransactionalAnnotationPointcut() {
		// Pointcut 을 위한 empty method
	}

//	@SneakyThrows
//	@Around("reactiveTransactionalAnnotationPointcut()")
//	public Object aroundReactiveTransaction(ProceedingJoinPoint pjp) {
//		Object[] args = pjp.getArgs();
//		MethodSignature signature = (MethodSignature)pjp.getSignature();
//
//		Class<?> returnType = signature.getReturnType();
//		if (returnType == Flux.class) {
//			Method method = signature.getMethod();
//			boolean readOnly = method.getAnnotation(ReactiveTransactional.class).readOnly();
//
//			return Mono.fromCallable(() -> transactionService.beginTransaction(readOnly))
//					   .thenMany((Flux)(pjp.proceed(args)))
//					   .doOnComplete(() -> transactionService.commit())
//					   .doOnError(e -> transactionService.rollback());
//		} else if (returnType == Mono.class) {
//			Method method = signature.getMethod();
//			boolean readOnly = method.getAnnotation(ReactiveTransactional.class).readOnly();
//
//			return Mono.fromCallable(() -> transactionService.beginTransaction(readOnly))
//					   .then((Mono)(pjp.proceed(args)))
//					   .doOnSuccess(nothing -> transactionService.commit())
//					   .doOnError(e -> transactionService.rollback());
//		} else {
//			return pjp.proceed(args);
//		}
//	}

}
