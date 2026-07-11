import fs from "fs";
import path from "path";
import { parse } from "csv-parse/sync";

export interface data {
    type: string;
    gender: string;
    firstname: string;
    lastname: string;
    email: string;
    password: string;
    confirmpassword: string;
}

export function readCSV(): data[] {

    const filePath = path.join(__dirname, "../test-data/register.csv");
    const fileContent = fs.readFileSync(filePath, "utf-8");

    return parse(fileContent, {
        columns: true,
        skip_empty_lines: true
    }) as data[];

}