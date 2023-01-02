use std::io;

fn main() {
    let mut intput = String::new();
    io::stdin().read_line(&mut intput).unwrap();

    let mut input: usize = intput.trim().parse::<usize>().unwrap();
    println!(fibo(input);)
}

fn fibo(n:usize) -> i32 {
    if n==1 || n==0 {
        1
    }
    else {
        fibo(n-1) + fibo(n-2)
    }
}
