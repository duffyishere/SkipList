use std::io;

fn main() {
    let input:Vec<usize> = read_line();
    let m = input.first().unwrap();
    let n = input.last().unwrap();

    let mut a: Vec<Vec<usize>> = vec![];
    let mut b: Vec<Vec<usize>> = vec![];

    for _ in 0..*n {
        a.push(read_line());
    }

    for _ in 0..*n {
        b.push(read_line());
    }

    for i in 0..*m {
        for j in 0..*n {
            print!("{} ", a[i][j]+b[i][j]);
        }
        println!();
    }
}

fn read_line() -> Vec<usize> {
    let mut a0 = String::new();
    io::stdin().read_line(&mut a0).unwrap();
    a0.split_ascii_whitespace().map(|s| s.trim().parse::<usize>().unwrap()).collect::<Vec<usize>>()
}