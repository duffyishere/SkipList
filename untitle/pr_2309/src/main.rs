use std::io;

fn main() {
    let mut inputs:[i32];
    for _ in 0..9 {
        let mut input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        inputs.push(input.trim().parse::<usize>().unwrap());
    }

    inputs.sort();

    println!("{:?}", inputs);

    std::
}
