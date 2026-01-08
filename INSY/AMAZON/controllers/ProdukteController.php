<?php

namespace app\controllers;

use app\models\Lieferanten;
use app\models\Produkte;
use app\models\ProdukteSearch;
use yii\helpers\ArrayHelper;
use yii\web\Controller;
use yii\web\NotFoundHttpException;
use yii\filters\VerbFilter;

/**
 * ProdukteController implements the CRUD actions for Produkte model.
 */
class ProdukteController extends Controller
{
    /**
     * @inheritDoc
     */
    public function behaviors()
    {
        return array_merge(
            parent::behaviors(),
            [
                'verbs' => [
                    'class' => VerbFilter::className(),
                    'actions' => [
                        'delete' => ['POST'],
                    ],
                ],
            ]
        );
    }

    /**
     * Lists all Produkte models.
     *
     * @return string
     */
    public function actionIndex()
    {
        $searchModel = new ProdukteSearch();
        $dataProvider = $searchModel->search($this->request->queryParams);

        return $this->render('index', [
            'searchModel' => $searchModel,
            'dataProvider' => $dataProvider,
        ]);
    }

    /**
     * Displays a single Produkte model.
     * @param string $ProduktID Produkt ID
     * @return string
     * @throws NotFoundHttpException if the model cannot be found
     */
    public function actionView($ProduktID)
    {
        return $this->render('view', [
            'model' => $this->findModel($ProduktID),
        ]);
    }

    /**
     * Creates a new Produkte model.
     * If creation is successful, the browser will be redirected to the 'view' page.
     * @return string|\yii\web\Response
     */
    public function actionCreate()
    {
        $model = new Produkte();

        $lieferanten = Lieferanten::find()->all();
        $lfdropdown = ArrayHelper::map($lieferanten, "LieferantenID", "Lieferantenname");

        if ($this->request->isPost) {
            if ($model->load($this->request->post()) && $model->save()) {
                return $this->redirect(['view', 'ProduktID' => $model->ProduktID]);
            }
        } else {
            $model->loadDefaultValues();
        }

        return $this->render('create', [
            'model' => $model,
            'dropdown' => $lfdropdown,
        ]);
    }

    /**
     * Updates an existing Produkte model.
     * If update is successful, the browser will be redirected to the 'view' page.
     * @param string $ProduktID Produkt ID
     * @return string|\yii\web\Response
     * @throws NotFoundHttpException if the model cannot be found
     */
    public function actionUpdate($ProduktID)
    {
        $model = $this->findModel($ProduktID);

        if ($this->request->isPost && $model->load($this->request->post()) && $model->save()) {
            return $this->redirect(['view', 'ProduktID' => $model->ProduktID]);
        }

        return $this->render('update', [
            'model' => $model,
        ]);
    }

    /**
     * Deletes an existing Produkte model.
     * If deletion is successful, the browser will be redirected to the 'index' page.
     * @param string $ProduktID Produkt ID
     * @return \yii\web\Response
     * @throws NotFoundHttpException if the model cannot be found
     */
    public function actionDelete($ProduktID)
    {
        $this->findModel($ProduktID)->delete();

        return $this->redirect(['index']);
    }

    /**
     * Finds the Produkte model based on its primary key value.
     * If the model is not found, a 404 HTTP exception will be thrown.
     * @param string $ProduktID Produkt ID
     * @return Produkte the loaded model
     * @throws NotFoundHttpException if the model cannot be found
     */
    protected function findModel($ProduktID)
    {
        if (($model = Produkte::findOne(['ProduktID' => $ProduktID])) !== null) {
            return $model;
        }

        throw new NotFoundHttpException(Yii::t('app', 'The requested page does not exist.'));
    }
}
