class Main {
    foo (a: Int , b: Int) : Int {
        a+b
    };

    x : Int <- 5+4;
    y: String <- "hello";
    z : Int;
    m : Int;
	main():IO {{
		x <- 5;
		m <- 9;
		x <- x + 5 * 8-7;
		(x + 5) * (8-7);
		if (x = 1) then m <- 1 else m <- 2 fi;
		while (x <= 9) loop x <- 1 pool;
		foo(5, 6);
		z <- foo(x, m);
    }};
};
