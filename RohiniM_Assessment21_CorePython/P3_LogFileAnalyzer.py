import re

try:
    file = open("server_log.txt", "r")
    lines = file.readlines()

    linesCount = len(lines)
    wordsCount = 0
    charCount = 0
    vowelCount = 0

    infoCount = 0
    warningCount = 0
    errorCount = 0
    criticalCount = 0

    alerts = []
    for line in lines:
        wordsCount += len(line.split())
        charCount += len(line)

        infoCount += len(re.findall(r'\[INFO\]', line))
        warningCount += len(re.findall(r'\[WARNING\]', line))
        errorCount += len(re.findall(r'\[ERROR\]', line))
        criticalCount += len(re.findall(r'\[CRITICAL\]', line))
        for ch in line.lower():
            if ch in "aeiou":
                vowelCount += 1
        if re.search(r'\[(ERROR|CRITICAL)\]', line):
            alerts.append(line.strip())

    report = open("log_report.txt", "w")

    report.write(f"Total Lines: {linesCount}\n")
    report.write(f"Total Words: {wordsCount}\n")
    report.write(f"Total Chars: {charCount}\n")
    report.write(f"Total Vowels: {vowelCount}\n")

    report.write(f"INFO:{infoCount}  WARNING:{warningCount}  ERROR:{errorCount}  CRITICAL:{criticalCount}\n")

    report.write("---ALERTS---\n")
    for alert in alerts:
        report.write(alert + "\n")

except FileNotFoundError:
    print("server_log.txt not found")

except Exception as e:
    print("Error:", e)

finally:
    file.close()
    report.close()