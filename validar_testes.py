import os
import glob
import xml.etree.ElementTree as etree
import os.path as osp
import json


def checa_aps(pref):
    testes = {}
    for f in glob.glob(f"target/surefire-reports/*{pref}.*.xml"):
        nome_test = osp.basename(f)
        test_results = {}
        x = etree.parse(f)

        for tst in x.findall("testcase"):
            test_results[tst.attrib["name"]] = (
                tst.find("error") == None and tst.find("failure") == None
            )

        testes[nome_test[5:-4]] = test_results

    return testes


def identifica_aluno():
    with open("README.md") as f:
        for l in f.readlines():
            if l.startswith("NOME:"):
                return l[6:].strip()

    return ""


def roda_testes():
    os.system("mvn -fae clean test > mvn-output.txt")


if __name__ == "__main__":
    nome_aluno = identifica_aluno()
    out = {"name": nome_aluno}

    roda_testes()

    out["sections"] = {f"APS0{i}": checa_aps(f"aps0{i}") for i in ["", 1, 2]}

    print(json.dumps(out, indent=2))
