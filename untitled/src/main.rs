use std::io;

fn main() {
    let buffer:Vec<usize> = read_line();
    // let m = buffer.first().expect("");
    // let n = buffer.last().expect("");

    let m:usize= 3;
    let n:usize = 3;
    let mut a: Vec<Vec<usize>> = vec![vec![1, 1, 1], vec![2, 2, 2], vec![0, 1, 0]];
    let mut b: Vec<Vec<usize>> = vec![vec![3, 3, 3], vec![4, 4, 4], vec![5, 5, 100]];

    for i in 0..m {
        println!("{}", a[i].join(" "));
    }
}

fn read_line() -> Vec<usize> {
    let mut a0 = String::new();
    io::stdin().read_line(&mut a0).expect("error");

    a0.split_whitespace()
        .map(|s| s.trim().parse().expect("error"))
        .collect::<Vec<_>>()
}